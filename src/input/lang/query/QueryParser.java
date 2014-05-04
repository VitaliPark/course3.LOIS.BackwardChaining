// $ANTLR 3.5.1 D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g 2014-05-04 15:17:33

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
			"','" };
	public static final int EOF = -1;
	public static final int T__7 = 7;
	public static final int T__8 = 8;
	public static final int T__9 = 9;
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

	// $ANTLR start "queryToDB"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:18:1:
	// queryToDB returns [Predicate pr] : ( query )? EOF ;
	public final Predicate queryToDB() throws RecognitionException {
		Predicate pr = null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:18:32:
			// ( ( query )? EOF )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:19:2:
			// ( query )? EOF
			{
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:19:2:
				// ( query )?
				int alt1 = 2;
				int LA1_0 = input.LA(1);
				if ((LA1_0 == VAR)) {
					alt1 = 1;
				}
				switch (alt1) {
				case 1:
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:19:2:
				// query
				{
					pushFollow(FOLLOW_query_in_queryToDB44);
					query();
					state._fsp--;

				}
					break;

				}

				match(input, EOF, FOLLOW_EOF_in_queryToDB47);
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
	// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:22:1:
	// query : VAR '(' param ')' ;
	public final void query() throws RecognitionException {
		Token VAR1 = null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:22:6:
			// ( VAR '(' param ')' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:23:2:
			// VAR '(' param ')'
			{
				VAR1 = (Token) match(input, VAR, FOLLOW_VAR_in_query60);
				predicate = new Predicate(
						(VAR1 != null ? VAR1.getText() : null));
				match(input, 7, FOLLOW_7_in_query71);
				pushFollow(FOLLOW_param_in_query73);
				param();
				state._fsp--;

				match(input, 8, FOLLOW_8_in_query75);
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
	// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:26:2:
	// param : (firstVar= VAR ( ',' nVar= VAR )* |firstConst= CONSTANT ( ','
	// nConst= CONSTANT )* );
	public final void param() throws RecognitionException {
		Token firstVar = null;
		Token nVar = null;
		Token firstConst = null;
		Token nConst = null;

		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:26:7:
			// (firstVar= VAR ( ',' nVar= VAR )* |firstConst= CONSTANT ( ','
			// nConst= CONSTANT )* )
			int alt4 = 2;
			int LA4_0 = input.LA(1);
			if ((LA4_0 == VAR)) {
				alt4 = 1;
			} else if ((LA4_0 == CONSTANT)) {
				alt4 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 4, 0,
						input);
				throw nvae;
			}

			switch (alt4) {
			case 1:
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:27:2:
			// firstVar= VAR ( ',' nVar= VAR )*
			{
				firstVar = (Token) match(input, VAR, FOLLOW_VAR_in_param89);
				predicate.addParameter(new Variable(
						(firstVar != null ? firstVar.getText() : null)));
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:28:3:
				// ( ',' nVar= VAR )*
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if ((LA2_0 == 9)) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:28:4:
					// ',' nVar= VAR
					{
						match(input, 9, FOLLOW_9_in_param98);
						nVar = (Token) match(input, VAR, FOLLOW_VAR_in_param105);
						predicate.addParameter(new Variable(
								(nVar != null ? nVar.getText() : null)));
					}
						break;

					default:
						break loop2;
					}
				}

			}
				break;
			case 2:
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:32:2:
			// firstConst= CONSTANT ( ',' nConst= CONSTANT )*
			{
				firstConst = (Token) match(input, CONSTANT,
						FOLLOW_CONSTANT_in_param123);
				predicate.addParameter(new Constant(
						(firstConst != null ? firstConst.getText() : null)));
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:33:3:
				// ( ',' nConst= CONSTANT )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == 9)) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:33:4:
					// ',' nConst= CONSTANT
					{
						match(input, 9, FOLLOW_9_in_param131);
						nConst = (Token) match(input, CONSTANT,
								FOLLOW_CONSTANT_in_param138);
						predicate.addParameter(new Constant(
								(nConst != null ? nConst.getText() : null)));
					}
						break;

					default:
						break loop3;
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

	public static final BitSet FOLLOW_query_in_queryToDB44 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_queryToDB47 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VAR_in_query60 = new BitSet(
			new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_7_in_query71 = new BitSet(
			new long[] { 0x0000000000000030L });
	public static final BitSet FOLLOW_param_in_query73 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_8_in_query75 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VAR_in_param89 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_9_in_param98 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_VAR_in_param105 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_CONSTANT_in_param123 = new BitSet(
			new long[] { 0x0000000000000202L });
	public static final BitSet FOLLOW_9_in_param131 = new BitSet(
			new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_CONSTANT_in_param138 = new BitSet(
			new long[] { 0x0000000000000202L });
}
