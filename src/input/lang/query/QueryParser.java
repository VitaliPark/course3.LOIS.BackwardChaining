// $ANTLR 3.5.1 D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g 2014-05-14 18:28:59

package input.lang.query;

import model.Predicate;
import model.parameters.*;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QueryParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "CONSTANT", "VAR", "WS", "'('", "')'",
			"','", "'.'" };
	public static final int EOF = -1;
	public static final int T__7 = 7;
	public static final int T__8 = 8;
	public static final int T__9 = 9;
	public static final int T__10 = 10;
	public static final int CONSTANT = 4;
	public static final int VAR = 5;
	public static final int WS = 6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	public QueryParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public QueryParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override
	public String[] getTokenNames() {
		return QueryParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g";
	}

	Predicate predicate;

	@Override
	public void reportError(RecognitionException e) {
		throw new RuntimeException(e);
	}

	// $ANTLR start "queryToDB"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:22:1:
	// queryToDB returns [Predicate pr] : query EOF ;
	public final Predicate queryToDB() throws RecognitionException {
		Predicate pr = null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:22:32:
			// ( query EOF )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:23:2:
			// query EOF
			{
				pushFollow(FOLLOW_query_in_queryToDB48);
				query();
				state._fsp--;

				match(input, EOF, FOLLOW_EOF_in_queryToDB50);
				pr = predicate;
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return pr;
	}

	// $ANTLR end "queryToDB"

	// $ANTLR start "query"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:26:1:
	// query : VAR '(' param ')' '.' ;
	public final void query() throws RecognitionException {
		Token VAR1 = null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:26:6:
			// ( VAR '(' param ')' '.' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:27:2:
			// VAR '(' param ')' '.'
			{
				VAR1 = (Token) match(input, VAR, FOLLOW_VAR_in_query63);
				predicate = new Predicate(
						(VAR1 != null ? VAR1.getText() : null));
				match(input, 7, FOLLOW_7_in_query74);
				pushFollow(FOLLOW_param_in_query76);
				param();
				state._fsp--;

				match(input, 8, FOLLOW_8_in_query78);
				match(input, 10, FOLLOW_10_in_query80);
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "query"

	// $ANTLR start "param"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:30:2:
	// param : (firstVar= VAR ( ',' nVar= VAR )* |firstConst= CONSTANT ( ','
	// nConst= CONSTANT )* );
	public final void param() throws RecognitionException {
		Token firstVar = null;
		Token nVar = null;
		Token firstConst = null;
		Token nConst = null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:30:7:
			// (firstVar= VAR ( ',' nVar= VAR )* |firstConst= CONSTANT ( ','
			// nConst= CONSTANT )* )
			int alt3 = 2;
			int LA3_0 = input.LA(1);
			if ((LA3_0 == VAR)) {
				alt3 = 1;
			} else if ((LA3_0 == CONSTANT)) {
				alt3 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0,
						input);
				throw nvae;
			}

			switch (alt3) {
			case 1:
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:31:2:
			// firstVar= VAR ( ',' nVar= VAR )*
			{
				firstVar = (Token) match(input, VAR, FOLLOW_VAR_in_param93);
				predicate.addParameter(new Parameter(ParameterType.VARIABLE,
						(firstVar != null ? firstVar.getText() : null)));
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:32:3:
				// ( ',' nVar= VAR )*
				loop1: while (true) {
					int alt1 = 2;
					int LA1_0 = input.LA(1);
					if ((LA1_0 == 9)) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:32:4:
					// ',' nVar= VAR
					{
						match(input, 9, FOLLOW_9_in_param102);
						nVar = (Token) match(input, VAR, FOLLOW_VAR_in_param109);
						predicate.addParameter(new Parameter(
								ParameterType.VARIABLE, (nVar != null ? nVar
										.getText() : null)));
					}
						break;

					default:
						break loop1;
					}
				}

			}
				break;
			case 2:
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:36:2:
			// firstConst= CONSTANT ( ',' nConst= CONSTANT )*
			{
				firstConst = (Token) match(input, CONSTANT,
						FOLLOW_CONSTANT_in_param127);
				predicate.addParameter(new Parameter(ParameterType.CONSTANT,
						(firstConst != null ? firstConst.getText() : null)));
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:37:3:
				// ( ',' nConst= CONSTANT )*
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if ((LA2_0 == 9)) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:37:4:
					// ',' nConst= CONSTANT
					{
						match(input, 9, FOLLOW_9_in_param135);
						nConst = (Token) match(input, CONSTANT,
								FOLLOW_CONSTANT_in_param142);
						predicate.addParameter(new Parameter(
								ParameterType.CONSTANT,
								(nConst != null ? nConst.getText() : null)));
					}
						break;

					default:
						break loop2;
					}
				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "param"

	// Delegated rules

	public static final BitSet FOLLOW_query_in_queryToDB48 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_queryToDB50 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VAR_in_query63 = new BitSet(
			new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_7_in_query74 = new BitSet(
			new long[] { 0x0000000000000030L });
	public static final BitSet FOLLOW_param_in_query76 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_8_in_query78 = new BitSet(
			new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_10_in_query80 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VAR_in_param93 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_9_in_param102 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_VAR_in_param109 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_CONSTANT_in_param127 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_9_in_param135 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_CONSTANT_in_param142 = new BitSet(
			new long[] { 0x0000000000000202L });
}
