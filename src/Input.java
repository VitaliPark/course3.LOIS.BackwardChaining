
import java.io.IOException;

import lang.logic.LogicLangLexer;
import lang.logic.LogicLangParser;
import model.Predicate;
import model.Rule;
import model.base.Base;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class Input {

	public static void main(String[] args) {
		CharStream charStream;
		try {
			charStream = new ANTLRFileStream("D:/Work/test.txt");
			LogicLangLexer lexer = new LogicLangLexer(charStream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			LogicLangParser parser = new LogicLangParser(tokenStream);
			parser.logicDB();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("sorry bitch!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.print("sorry bitch!");
		}
		System.out.print("done");
	}

}
