package input;

import input.lang.logic.LogicLangLexer;
import input.lang.logic.LogicLangParser;
import input.lang.query.QueryLexer;
import input.lang.query.QueryParser;

import java.io.IOException;

import javax.swing.JFileChooser;

import model.Predicate;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class LogicReader {

	private JFileChooser fileChooser = new JFileChooser();
	private CharStream charStream;

	public String read() {
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				charStream = new ANTLRFileStream(fileChooser.getSelectedFile()
						.getPath());
				LogicLangLexer lexer = new LogicLangLexer(charStream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				LogicLangParser parser = new LogicLangParser(tokenStream);
				parser.logicDB();
				return charStream.toString();
			} catch (RecognitionException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		System.out.print("done");
		return null;
	}

	public Predicate checkQuery(String input) {
		try {
			charStream = new ANTLRStringStream(input);
			QueryLexer lexer = new QueryLexer(charStream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			QueryParser parser = new QueryParser(tokenStream);
			return parser.queryToDB();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return null;

	}
}
