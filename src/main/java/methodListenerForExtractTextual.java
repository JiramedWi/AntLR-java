import Java8.Java8BaseListener;
import Java8.Java8Parser;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.google.common.base.CaseFormat;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class methodListenerForExtractTextual extends Java8BaseListener {

    String methodName = "";
    String className = "";
    Map<String, List<String>> methodCalled;
    Map<String, List<String>> classCalled;

    public Map<String, List<String>> getClassCalled() {
        return classCalled;
    }

    public Map<String, List<String>> getMethodCalled() {
        return methodCalled;
    }

    @Override
    public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        TerminalNode node = ctx.normalClassDeclaration().Identifier();
        className = node.getText();
        List<String> newClass = new ArrayList<>();
        if (classCalled == null) {
            classCalled = new HashMap<>();
        }
        classCalled.put(className, newClass);
        try (FileWriter writer = new FileWriter("test.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);) {
            printWriter.println(" ");
            printWriter.print("Class " + className+"@@");
        } catch (IOException i) {
            i.printStackTrace();
        }
//        System.out.println(ctx.getText());
        System.out.println("Enter class: " + className);

    }

    @Override
    public void exitClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        System.out.println("Exit class: " + className);
    }

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        TerminalNode node = ctx.Identifier();
        methodName = node.getText();
        List<String> newMethod = new ArrayList<>();
        if (methodCalled == null) {
            methodCalled = new HashMap<>();
        }
        methodCalled.put(methodName, newMethod);
        try (FileWriter writer = new FileWriter("test.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);) {
            printWriter.print(" " + methodName);
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Enter Method: " + methodName);
    }

    @Override
    public void exitMethodBody(Java8Parser.MethodBodyContext ctx) {
        System.out.println("");
        System.out.println("Exit Method: " + methodName);
    }

    @Override
    public void enterFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        for (int i = 0; i< ctx.getChildCount(); i++){
            System.out.println("this is fieldDeclaration");
            System.out.println(splitCamelCaseString(ctx.getChild(i).getText()));
            try (FileWriter writer = new FileWriter("test.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter);) {
                printWriter.print(" " + splitCamelCaseString(ctx.getChild(i).getText()));
            } catch (IOException a) {
                a.printStackTrace();
            }
        }
        System.out.println("this is a fieldDeclaration");
        System.out.println(splitCamelCaseString(ctx.getText()));
    }


   @Override
    public void enterBlockStatement(Java8Parser.BlockStatementContext ctx) {
        for (int i = 0; i< ctx.getChildCount(); i++){
            System.out.println("this is blockStatement");
            System.out.println(ctx.getChild(i).getText());
            System.out.println(splitCamelCaseString(ctx.getChild(i).getText()));
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);) {
                    printWriter.print(" " + splitCamelCaseString(ctx.getChild(i).getText()));
                } catch (IOException a) {
                    a.printStackTrace();
                }
        }
    }
    public static LinkedList<String> splitCamelCaseString(String s){
        LinkedList<String> result = new LinkedList<String>();
        for (String w : s.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
            w = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, w);
            result.add(w);
        }
        return result;
    }
}
