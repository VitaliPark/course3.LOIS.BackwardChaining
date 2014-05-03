// $ANTLR 3.5.1 D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g 2014-05-03 17:59:19

package lang.query;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QueryParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "CONSTANT", "VAR", "WS", "'('", "')'",
			"','", "'-'", "'?'" };
	public static final int EOF = -1;
	public static final int T__7 = 7;
	public static final int T__8 = 8;
	public static final int T__9 = 9;
	public static final int T__10 = 10;
	public static final int T__11 = 11;
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
		return "D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g";
	}

	// $ANTLR start "queryToDB"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:13:1:
	// queryToDB : ( query )* EOF ;
	public final void queryToDB() throws RecognitionException {
		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:13:10:
			// ( ( query )* EOF )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:14:2:
			// ( query )* EOF
			{
				// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:14:2:
				// ( query )*
				loop1: while (true) {
					int alt1 = 2;
					int LA1_0 = input.LA(1);
					if ((LA1_0 == VAR)) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:14:2:
					// query
					{
						pushFollow(FOLLOW_query_in_queryToDB37);
						query();
						state._fsp--;

					}
						break;

					default:
						break loop1;
					}
				}

				match(input, EOF, FOLLOW_EOF_in_queryToDB40);
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "queryToDB"

	// $ANTLR start "query"
	// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:16:1:
	// query : VAR '(' ( VAR | CONSTANT ) ( ',' ( VAR | CONSTANT ) )* ')' '-'
	// '?' ;
	public final void query() throws RecognitionException {
		try {
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:16:6:
			// ( VAR '(' ( VAR | CONSTANT ) ( ',' ( VAR | CONSTANT ) )* ')' '-'
			// '?' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:17:2:
			// VAR '(' ( VAR | CONSTANT ) ( ',' ( VAR | CONSTANT ) )* ')' '-'
			// '?'
			{
				match(input, VAR, FOLLOW_VAR_in_query50);
				match(input, 7, FOLLOW_7_in_query52);
				if ((input.LA(1) >= CONSTANT && input.LA(1) <= VAR)) {
					input.consume();
					state.errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					throw mse;
				}
				// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:17:25:
				// ( ',' ( VAR | CONSTANT ) )*
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if ((LA2_0 == 9)) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\lang\\query\\Query.g:17:26:
					// ',' ( VAR | CONSTANT )
					{
						match(input, 9, FOLLOW_9_in_query61);
						if ((input.LA(1) >= CONSTANT && input.LA(1) <= VAR)) {
							input.consume();
							state.errorRecovery = false;
						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							throw mse;
						}
					}
						break;

					default:
						break loop2;
					}
				}

				match(input, 8, FOLLOW_8_in_query71);
				match(input, 10, FOLLOW_10_in_query73);
				match(input, 11, FOLLOW_11_in_query75);
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "query"

	// Delegated rules

	public static final BitSet FOLLOW_query_in_queryToDB37 = new BitSet(
			new long[] { 0x0000000000000020L });
	public static final BitSet FOLLOW_EOF_in_queryToDB40 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VAR_in_query50 = new BitSet(
			new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_7_in_query52 = new BitSet(
			new long[] { 0x0000000000000030L });
	public static final BitSet FOLLOW_set_in_query54 = new BitSet(
			new long[] { 0x0000000000000300L });
	public static final BitSet FOLLOW_9_in_query61 = new BitSet(
			new long[] { 0x0000000000000030L });
	public static final BitSet FOLLOW_set_in_query63 = new BitSet(
			new long[] { 0x0000000000000300L });
	public static final BitSet FOLLOW_8_in_query71 = new BitSet(
			new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_10_in_query73 = new BitSet(
			new long[] { 0x0000000000000800L });
	public static final BitSet FOLLOW_11_in_query75 = new BitSet(
			new long[] { 0x0000000000000002L });
}
