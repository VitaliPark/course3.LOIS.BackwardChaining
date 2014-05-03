// $ANTLR 3.5.1 D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g 2014-05-03 21:45:05

  package lang.logic;
  import model.*; 
  import model.parameters.*;
  import model.base.*;
  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LogicLangParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CONSTANT", "VAR", "WS", "'('", 
		"')'", "','", "'.'", "';'", "'<-'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int CONSTANT=4;
	public static final int VAR=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public LogicLangParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public LogicLangParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return LogicLangParser.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g"; }





	// $ANTLR start "logicDB"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:18:1: logicDB : ( rule | fact )* EOF ;
	public final void logicDB() throws RecognitionException {
		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:18:8: ( ( rule | fact )* EOF )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:19:2: ( rule | fact )* EOF
			{
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:19:2: ( rule | fact )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==VAR) ) {
					int LA1_2 = input.LA(2);
					if ( (LA1_2==7) ) {
						int LA1_3 = input.LA(3);
						if ( (LA1_3==CONSTANT) ) {
							alt1=2;
						}
						else if ( (LA1_3==VAR) ) {
							alt1=1;
						}

					}

				}

				switch (alt1) {
				case 1 :
					// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:19:3: rule
					{
					pushFollow(FOLLOW_rule_in_logicDB41);
					rule();
					state._fsp--;

					}
					break;
				case 2 :
					// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:19:8: fact
					{
					pushFollow(FOLLOW_fact_in_logicDB43);
					fact();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_logicDB47); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "logicDB"



	// $ANTLR start "fact"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:22:1: fact : VAR '(' firstConst= CONSTANT ( ',' nConst= CONSTANT )* ')' '.' ;
	public final void fact() throws RecognitionException {
		Token firstConst=null;
		Token nConst=null;
		Token VAR1=null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:22:5: ( VAR '(' firstConst= CONSTANT ( ',' nConst= CONSTANT )* ')' '.' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:23:2: VAR '(' firstConst= CONSTANT ( ',' nConst= CONSTANT )* ')' '.'
			{
			VAR1=(Token)match(input,VAR,FOLLOW_VAR_in_fact58); 
			Predicate pr=new Predicate((VAR1!=null?VAR1.getText():null));
			match(input,7,FOLLOW_7_in_fact63); 
			firstConst=(Token)match(input,CONSTANT,FOLLOW_CONSTANT_in_fact69); 
			pr.addParameter(new Constant((firstConst!=null?firstConst.getText():null)));
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:26:2: ( ',' nConst= CONSTANT )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==9) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:26:3: ',' nConst= CONSTANT
					{
					match(input,9,FOLLOW_9_in_fact75); 
					nConst=(Token)match(input,CONSTANT,FOLLOW_CONSTANT_in_fact81); 
					pr.addParameter(new Constant((nConst!=null?nConst.getText():null)));
					}
					break;

				default :
					break loop2;
				}
			}

			match(input,8,FOLLOW_8_in_fact90); 
			match(input,10,FOLLOW_10_in_fact92); 
			Base.INSTANCE.addRule(new Rule(pr));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "fact"



	// $ANTLR start "rule"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:31:1: rule : main= predicate '<-' firstPr= predicate ( ';' nPr= predicate )* '.' ;
	public final void rule() throws RecognitionException {
		Predicate main =null;
		Predicate firstPr =null;
		Predicate nPr =null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:31:5: (main= predicate '<-' firstPr= predicate ( ';' nPr= predicate )* '.' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:32:2: main= predicate '<-' firstPr= predicate ( ';' nPr= predicate )* '.'
			{
			pushFollow(FOLLOW_predicate_in_rule109);
			main=predicate();
			state._fsp--;

			Predicate pr=main;
									Rule rule=new Rule(pr);
			match(input,12,FOLLOW_12_in_rule116); 
			pushFollow(FOLLOW_predicate_in_rule122);
			firstPr=predicate();
			state._fsp--;

			rule.addRuleTerm(firstPr);
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:36:3: ( ';' nPr= predicate )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==11) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:36:4: ';' nPr= predicate
					{
					match(input,11,FOLLOW_11_in_rule129); 
					pushFollow(FOLLOW_predicate_in_rule136);
					nPr=predicate();
					state._fsp--;

					rule.addRuleTerm(nPr);
					}
					break;

				default :
					break loop3;
				}
			}

			match(input,10,FOLLOW_10_in_rule146); 
			Base.INSTANCE.addRule(rule);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rule"



	// $ANTLR start "predicate"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:41:1: predicate returns [Predicate result] : name= VAR '(' firstVar= VAR ( ',' nVar= VAR )* ')' ;
	public final Predicate predicate() throws RecognitionException {
		Predicate result = null;


		Token name=null;
		Token firstVar=null;
		Token nVar=null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:41:36: (name= VAR '(' firstVar= VAR ( ',' nVar= VAR )* ')' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:42:2: name= VAR '(' firstVar= VAR ( ',' nVar= VAR )* ')'
			{
			name=(Token)match(input,VAR,FOLLOW_VAR_in_predicate167); 
			match(input,7,FOLLOW_7_in_predicate169); 
			Predicate pr=new Predicate((name!=null?name.getText():null));
			firstVar=(Token)match(input,VAR,FOLLOW_VAR_in_predicate178); 
			pr.addParameter(new Variable((firstVar!=null?firstVar.getText():null)));
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:44:2: ( ',' nVar= VAR )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==9) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\logic\\LogicLang.g:44:3: ',' nVar= VAR
					{
					match(input,9,FOLLOW_9_in_predicate186); 
					nVar=(Token)match(input,VAR,FOLLOW_VAR_in_predicate192); 
					pr.addParameter(new Variable((nVar!=null?nVar.getText():null)));
					}
					break;

				default :
					break loop4;
				}
			}

			match(input,8,FOLLOW_8_in_predicate203); 
			result =pr;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "predicate"

	// Delegated rules



	public static final BitSet FOLLOW_rule_in_logicDB41 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_fact_in_logicDB43 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EOF_in_logicDB47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_fact58 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_fact63 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CONSTANT_in_fact69 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_9_in_fact75 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CONSTANT_in_fact81 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_8_in_fact90 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_fact92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_predicate_in_rule109 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_rule116 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_predicate_in_rule122 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_rule129 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_predicate_in_rule136 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_10_in_rule146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_predicate167 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_predicate169 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_VAR_in_predicate178 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_9_in_predicate186 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_VAR_in_predicate192 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_8_in_predicate203 = new BitSet(new long[]{0x0000000000000002L});
}
