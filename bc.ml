open Core

type result =
    | RNum of float
    | RError of string

type sExpr = 
    | Atom of string
    | List of sExpr list

type expr = 
    | Num of float
    | Var of string
    | Op1 of string*expr            (*unary expression*)
    | Op2 of string*expr*expr       (*binary expression*)
    | Fct of string * expr list
(*
    if-then-else statements
    while statements
    for loops
    user-defined functions
*)
type statement = 
    | Assign of string*expr
    | Return of expr
    | Expr of expr
    | If of expr*statement list * statement list
    | While of expr*statement list
    | For of statement*expr*statement*statement list
    | FctDef of string * string list * statement list 

type block = statement list 

type env = N of float (* complete *)

type envQueue = EnvQ of env list

(*module MyVariables = Map.Make(String)
let m = MyVariables.empty*)

let varEval (_v: string) (_q:envQueue): float  = 
    match _q with
    | EnvQ([]) -> 0.
    | EnvQ(h::t) -> if _v=h then h else 0.

let evalExpr (_e: expr) (_q:envQueue): float  = 
    match _e with
    | Num(f)-> f
    | Var(v) -> varEval v _q 
    (*| Op1 ->
    | Op2 ->
    | Fct ->*)

(* Test for expression *)
let%expect_test "evalNum" = 
    evalExpr (Num 10.0) [] |>
    printf "%F";
    [%expect {| 10. |}]



let evalCode (_code: block) (_q:envQueue): unit = 
    (* crate new environment *)
    (* user fold_left  *)
    (* pop the local environment *)
    match _q with
    | EnvQ(lst) -> let result = List.fold_left evalStatement _code lst in
                    match result with
                    | EnvQ(v::[]) -> printf v
                    | EnvQ(_::_::_) -> RError("Too many items on the stack")
                    | EnvQ [] -> RError "No values on the stack"
                    | SError(str) -> RError str         
        
                       
                        

let evalStatement (s: statement) (q:envQueue): envQueue =
    match s with 
        | Assign(_v, _e) -> let _v = evalExpr _e q in
                            (*let m = MyVariables.add _v x m in*)
                            match q with
                            | EnvQ(lst) -> EnvQ(_v :: lst)
        | Expr(_e) -> let x = evalExpr _e q in
                      match q with
                      |EnvQ(lst) -> EnvQ(x::lst)
        | _ -> q (*ignore *)
        (*| Return(_e)-> evalExpr _e q
        
        | If(e, codeT, codeF) -> 
            let cond = evalExpr e q in
                if(cond>0.0) then
                    evalCode codeT q 
                else
                    evalCode codeF q
            ;q
        | While ->
        | For ->
        | FctDef -> 
        *)


(* 
    v = 10; 
    v // display v
 *)
let p1: block = [
        Assign("v", Num(1.0));
        Expr(Var("v")) 
]

let%expect_test "p1" =
    evalCode p1 []; 
    [%expect {| 1. |}]

(*
    v = 1.0;
    if (v>10.0) then
        v = v + 1.0
    else
        for(i=2.0; i<10.0; i++) {
            v = v * i
        }
    v   // display v
*)
let p2: block = [
    Assign("v", Num(1.0));
    If(
        Op2(">", Var("v"), Num(10.0)), 
        [Assign("v", Op2("+", Var("v"), Num(1.0)))], 
        [For(
            Assign("i", Num(2.0)),
            Op2("<", Var("i"), Num(10.0)),
            Expr(Op1("++a", Var("i"))),
            [
                Assign("v", Op2("*", Var("v"), Var("i")))
            ]
        )]
    );
    Expr(Var("v"))
]

let%expect_test "p1" =
    evalCode p2 []; 
    [%expect {| 3628800. |}]

(*  Fibbonaci sequence
    define f(x) {
        if (x<1.0) then
            return (1.0)
        else
            return (f(x-1)+f(x-2))
    }

    f(3)
    f(5)
 *)
let p3: block = 
    [
        FctDef("f", ["x"], [
            If(
                Op2("<", Var("x"), Num(1.0)),
                [Return(Num(1.0))],
                [Return(Op2("+",
                    Fct("f", [Op2("-", Var("x"), Num(1.0))]),
                    Fct("f", [Op2("-", Var("x"), Num(1.0))])
                ))])
        ]);
        Expr(Fct("f", [Num(3.0)]));
        Expr(Fct("f", [Num(5.0)]));
    ]

let%expect_test "p3" =
    evalCode p3 []; 
    [%expect {| 
        2. 
        5.      
    |}]



