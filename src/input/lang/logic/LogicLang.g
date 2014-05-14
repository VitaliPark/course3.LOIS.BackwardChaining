grammar LogicLang;

options {
  language = Java;
}

@header {
  package input.lang.logic;
  import model.*; 
  import model.parameters.*;
  import model.base.*;
  
}
@lexer::header {
  package input.lang.logic;
}
@parser::members {
    @Override
    public void reportError(RecognitionException e) {
        throw new RuntimeException(e);
    }
}
logicDB:
	(rule|fact)* EOF 
	;

fact:
	VAR {Predicate pr=new Predicate($VAR.text);}
	'(' 
	firstConst=CONSTANT {pr.addParameter(new Parameter(ParameterType.CONSTANT,$firstConst.text));}
	(',' 
	nConst=CONSTANT 	{pr.addParameter(new Parameter(ParameterType.CONSTANT,$nConst.text));}
	)* ')' '.'			{Base.INSTANCE.addRule(new Rule(pr));}
	;
	
rule:
	main=predicate 		{Predicate pr=$main.result;
						Rule rule=new Rule(pr);}
	'<-' 
	firstPr=predicate	{rule.addRuleTerm($firstPr.result);}
	 (';' 
	 nPr=predicate		{rule.addRuleTerm($nPr.result);}
	 )* '.'				{Base.INSTANCE.addRule(rule);}
	;
	
predicate returns[Predicate result]:
	name=VAR '(' 		{Predicate pr=new Predicate($name.text);}
	firstVar=VAR 		{pr.addParameter(new Parameter(ParameterType.VARIABLE,$firstVar.text));}
	(',' 
	nVar=VAR	 		{pr.addParameter(new Parameter(ParameterType.VARIABLE,$nVar.text));}
	)* ')'
						{$result=pr;}
	;
	
VAR:
	'A'..'Z'+
	;
	
CONSTANT:
	'a'..'z'+
	;
	
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };
	