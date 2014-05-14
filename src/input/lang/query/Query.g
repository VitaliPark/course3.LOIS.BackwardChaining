grammar Query;

options {
  language = Java;
}

@header {
  package input.lang.query; 
   import model.Predicate;
   import model.parameters.*;
}
@lexer::header {
  package input.lang.query;
}
@parser::members {
	Predicate predicate;
    @Override
    public void reportError(RecognitionException e) {
        throw new RuntimeException(e);
    }
}
queryToDB returns[Predicate pr]:
	query EOF 
	{$pr=predicate;}
	;
query:
	VAR						{predicate=new Predicate($VAR.text);}
	 '(' param ')'	'.'	
	;
	param:
	firstVar=VAR			{predicate.addParameter(new Variable($firstVar.text));}
	 (',' 
	 nVar=VAR				{predicate.addParameter(new Variable($nVar.text));}
	 )*
	|
	firstConst=CONSTANT		{predicate.addParameter(new Constant($firstConst.text));}
	 (',' 
	 nConst=CONSTANT		{predicate.addParameter(new Constant($nConst.text));}
	 )* 
	;
VAR:
	'A'..'Z'+
	;
CONSTANT:
	'a'..'z'+
	;
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };
	