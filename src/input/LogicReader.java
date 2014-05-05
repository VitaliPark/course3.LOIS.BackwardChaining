package input;

import input.lang.logic.LogicLangLexer;
import input.lang.logic.LogicLangParser;
import input.lang.query.QueryLexer;
import input.lang.query.QueryParser;

import java.io.IOException;

import javax.swing.JFileChooser;

import model.Predicate;
import model.base.Base;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class LogicReader {

	private static final String INCORRECT_FILE = "incorrect file";
	private JFileChooser fileChooser = new JFileChooser();
	private CharStream charStream;
	private TokenStream tokenStream;
	private QueryLexer queryLexer;
	private QueryParser queryParser;
	private LogicLangLexer logicLexer;
	private LogicLangParser logicParser;

	public String read() {
		Base.INSTANCE.cleanBase();
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				charStream = new ANTLRFileStream(fileChooser.getSelectedFile()
						.getPath());
				logicLexer = new LogicLangLexer(charStream);
				tokenStream = new CommonTokenStream(logicLexer);
				logicParser = new LogicLangParser(tokenStream);
				logicParser.logicDB();
				return charStream.toString();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (RecognitionException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				return INCORRECT_FILE;
			}

		}
		return null;
	}

	public Predicate checkQuery(String input) {
		try {
			charStream = new ANTLRStringStream(input);
			queryLexer = new QueryLexer(charStream);
			tokenStream = new CommonTokenStream(queryLexer);
			queryParser = new QueryParser(tokenStream);
			return queryParser.queryToDB();
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			return null;
		}
		return null;
	}

}
