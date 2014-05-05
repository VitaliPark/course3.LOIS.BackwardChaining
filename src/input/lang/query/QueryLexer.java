// $ANTLR 3.5.1 D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g 2014-05-05 22:40:45

package input.lang.query;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QueryLexer extends Lexer {
	public static final int EOF = -1;
	public static final int T__7 = 7;
	public static final int T__8 = 8;
	public static final int T__9 = 9;
	public static final int T__10 = 10;
	public static final int CONSTANT = 4;
	public static final int VAR = 5;
	public static final int WS = 6;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public QueryLexer() {
	}

	public QueryLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public QueryLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override
	public String getGrammarFileName() {
		return "D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g";
	}

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:11:6:
			// ( '(' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:11:8:
			// '('
			{
				match('(');
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "T__7"

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:12:6:
			// ( ')' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:12:8:
			// ')'
			{
				match(')');
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:13:6:
			// ( ',' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:13:8:
			// ','
			{
				match(',');
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:14:7:
			// ( '.' )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:14:9:
			// '.'
			{
				match('.');
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "T__10"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:41:4:
			// ( ( 'A' .. 'Z' )+ )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:42:2:
			// ( 'A' .. 'Z' )+
			{
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:42:2:
				// ( 'A' .. 'Z' )+
				int cnt1 = 0;
				loop1: while (true) {
					int alt1 = 2;
					int LA1_0 = input.LA(1);
					if (((LA1_0 >= 'A' && LA1_0 <= 'Z'))) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:
					{
						if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z')) {
							input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}
					}
						break;

					default:
						if (cnt1 >= 1)
							break loop1;
						EarlyExitException eee = new EarlyExitException(1,
								input);
						throw eee;
					}
					cnt1++;
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "VAR"

	// $ANTLR start "CONSTANT"
	public final void mCONSTANT() throws RecognitionException {
		try {
			int _type = CONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:44:9:
			// ( ( 'a' .. 'z' )+ )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:45:2:
			// ( 'a' .. 'z' )+
			{
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:45:2:
				// ( 'a' .. 'z' )+
				int cnt2 = 0;
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if (((LA2_0 >= 'a' && LA2_0 <= 'z'))) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:
					{
						if ((input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
							input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}
					}
						break;

					default:
						if (cnt2 >= 1)
							break loop2;
						EarlyExitException eee = new EarlyExitException(2,
								input);
						throw eee;
					}
					cnt2++;
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "CONSTANT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:47:4:
			// ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:47:6:
			// ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
				// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:47:6:
				// ( ' ' | '\\t' | '\\r' | '\\n' )+
				int cnt3 = 0;
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if (((LA3_0 >= '\t' && LA3_0 <= '\n') || LA3_0 == '\r' || LA3_0 == ' ')) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:
					{
						if ((input.LA(1) >= '\t' && input.LA(1) <= '\n')
								|| input.LA(1) == '\r' || input.LA(1) == ' ') {
							input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}
					}
						break;

					default:
						if (cnt3 >= 1)
							break loop3;
						EarlyExitException eee = new EarlyExitException(3,
								input);
						throw eee;
					}
					cnt3++;
				}

				_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:8:
		// ( T__7 | T__8 | T__9 | T__10 | VAR | CONSTANT | WS )
		int alt4 = 7;
		switch (input.LA(1)) {
		case '(': {
			alt4 = 1;
		}
			break;
		case ')': {
			alt4 = 2;
		}
			break;
		case ',': {
			alt4 = 3;
		}
			break;
		case '.': {
			alt4 = 4;
		}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z': {
			alt4 = 5;
		}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z': {
			alt4 = 6;
		}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ': {
			alt4 = 7;
		}
			break;
		default:
			NoViableAltException nvae = new NoViableAltException("", 4, 0,
					input);
			throw nvae;
		}
		switch (alt4) {
		case 1:
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:10:
		// T__7
		{
			mT__7();

		}
			break;
		case 2:
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:15:
		// T__8
		{
			mT__8();

		}
			break;
		case 3:
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:20:
		// T__9
		{
			mT__9();

		}
			break;
		case 4:
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:25:
		// T__10
		{
			mT__10();

		}
			break;
		case 5:
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:31:
		// VAR
		{
			mVAR();

		}
			break;
		case 6:
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:35:
		// CONSTANT
		{
			mCONSTANT();

		}
			break;
		case 7:
		// D:\\Work\\Projects\\Logical—onsequence\\src\\input\\lang\\query\\Query.g:1:44:
		// WS
		{
			mWS();

		}
			break;

		}
	}

}
