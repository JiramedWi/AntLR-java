import Java8.Java8Lexer;
import Java8.Java8Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ParserTest {
    @Test
    public void parserTest(){
        String filecontent = "public class SampleClass { void DoSomething(){} }";
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromString(filecontent));
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
        methoDlistener listener = new methoDlistener();
        walker.walk(listener, tree);
    }

    @Test
    public void parserTest2() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ExamResultServiceImpl.java");
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromStream(inputStream));
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();

        methoDlistener methoDlistener = new methoDlistener();
        parser.addParseListener(methoDlistener);
        parser.compilationUnit().enterRule(methoDlistener);
        walker.walk(methoDlistener,tree);
    }

    @Test
    public void parserTest2_2() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ExamResultServiceImpl.java");
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromStream(inputStream));
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();

        methodListener2 methodListener = new methodListener2();
        walker.walk(methodListener,tree);
    }

    @Test
    public void parserTest3() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ExamResultServiceImpl.java");
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromStream(inputStream));
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();

        methodListener3 methodListener = new methodListener3();
        walker.walk(methodListener,tree);
    }

    @Test
    public void parserTest4() throws IOException {
//        File folder = new File("your/path");
//        File[] listOfFiles = folder.listFiles();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("CommandlineJavaTest.java");
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromStream(inputStream));
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();

        methodListener4 methodListener = new methodListener4();
        walker.walk(methodListener,tree);
        System.out.println((methodListener.getMethodcalled()));


    }
}
