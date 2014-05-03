grammar Query;

options {
  language = Java;
}

@header {
  package lang.query; 
}
@lexer::header {
  package lang.query;
}
queryToDB:
	query* EOF 
	;
query:
	VAR '(' (VAR|CONSTANT) (',' (VAR|CONSTANT))* ')' '-' '?'
	;
VAR:
	'A'..'Z'
	;
CONSTANT:
	'a'..'z'
	;
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };
	