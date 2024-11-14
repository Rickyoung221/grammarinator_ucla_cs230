grammar Calculator;

// parser
 
equation :
    expr EOF ;
 
expr :
   expr mulop expr            # MULOPGRP
   | expr addop expr            # ADDOPGRP
   | expr mulop uminus      # MULOPGRP1
   | expr addop uminus      # ADDOPGRP2
   | atom                       # DOUBLE
   ;

uminus :
   '(' '-' NUMBER ')'  ;
 
addop : '+' | '-' ;
 
mulop : '*' | '/' | '%' | '^' ;
 
atom
    : NUMBER                // Allows only a single number
    | '(' expr ')'          // Parenthesized expressions
    ;
 
// lexer
 
NUMBER
    : '0'                                // Matches a single zero
    | [1-9] ('0' .. '9')*                 // Matches integers without leading zeros
    | [1-9] ('0' .. '9')* '.' ('0' .. '9')+ // Matches decimals without leading zeros
    | '0' '.' ('0' .. '9')+               // Matches decimals starting with "0."
    ;

WS : [ \r\n\t]+ -> skip ;
