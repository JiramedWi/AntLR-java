import Java8.Java8BaseListener;
import Java8.Java8Parser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class methodListener4 extends Java8BaseListener {

    String methodName = "";
    Map<String, List<String>> methodcalled;

    public Map<String, List<String>> getMethodcalled() {
        return methodcalled;
    }

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("step");
//        sb.append(',');
//        sb.append("name");
//        sb.append('\n');

        TerminalNode node = ctx.Identifier();
        methodName = node.getText();
        List<String> newMethod = new ArrayList<>();
        if(methodcalled == null){
            methodcalled = new HashMap<>();
        }
        methodcalled.put(methodName, newMethod);
        try (FileWriter writer = new FileWriter("test.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);){
            printWriter.println("Enter method name" + "," + methodName);
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Enter method name: " + methodName);

    }

    @Override
    public void exitMethodBody(Java8Parser.MethodBodyContext ctx) {
        try (FileWriter writer = new FileWriter("test.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);){
            printWriter.println("Exit method name"+"," + methodName);
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Exit method name: " + methodName);


    }

//    @Override
//    public void exitMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
//        TerminalNode node = ctx.Identifier();
//        String methodName = node.getText();
//        System.out.println("Exit method name: " + methodName);
//    }

    @Override
    public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
        StringBuilder sb = new StringBuilder();

        TerminalNode node = ctx.Identifier();
        String callMethod = null;
        if (node != null){
        callMethod = ctx.Identifier().getText();
        }
        System.out.println("\t call method: " + callMethod);
            try (FileWriter writer = new FileWriter("test.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                printWriter.println("call method"+"," + callMethod);
            } catch (IOException i) {
                i.printStackTrace();
            }
        if (ctx.getChild(0) instanceof Java8Parser.TypeNameContext){
            System.out.println("\t\t call variable: " + ctx.getChild(0).getText());
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("call variable"+"," + ctx.getChild(0).getText());
                } catch (IOException i) {
                    i.printStackTrace();
                }
            if (ctx.argumentList() != null) {
                for (int i = 0; i < ctx.argumentList().expression().size(); i++) {
                    System.out.println("\t\t argument: " +
                            ctx.argumentList().expression(i).getText() + ","+" TypeNameContext");
                    try (FileWriter writer = new FileWriter("test.txt", true);
                         BufferedWriter bufferedWriter = new BufferedWriter(writer);
                         PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                        printWriter.println("argument"+"," + ctx.argumentList().expression(i).getText());
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                }
            }
        }
        if (ctx.getChild(0) instanceof Java8Parser.PrimaryContext){
            System.out.println("\t\t call variable: " + ctx.getChild(0).getText());
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("call variable"+"," + ctx.getChild(0).getText());
                } catch (IOException i) {
                    i.printStackTrace();
                }
            if (ctx.argumentList() != null) {
                for (int i = 0; i < ctx.argumentList().expression().size(); i++) {
                    System.out.println("\t\t argument: " +
                            ctx.argumentList().expression(i).getText() + ","+" PrimaryContext");
                    try (FileWriter writer = new FileWriter("test.txt", true);
                         BufferedWriter bufferedWriter = new BufferedWriter(writer);
                         PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                        printWriter.println("argument"+"," + ctx.argumentList().expression(i).getText());
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                }
            }
        }
        if (ctx.getChild(0)  instanceof Java8Parser.MethodNameContext){
            System.out.println("\t\t call variable: " + ctx.getChild(0).getText());
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("call variable"+"," + ctx.getChild(0).getText());
                } catch (IOException i) {
                    i.printStackTrace();
                }
            if (ctx.argumentList() != null) {
                for (int i = 0; i < ctx.argumentList().expression().size(); i++) {
                    System.out.println("\t\t argument: " +
                            ctx.argumentList().expression(i).getText() + ","+" MethodNameContext");
                    try (FileWriter writer = new FileWriter("test.txt", true);
                         BufferedWriter bufferedWriter = new BufferedWriter(writer);
                         PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                        printWriter.println("argument"+"," + ctx.argumentList().expression(i).getText());
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                }
            }

        }
        if (ctx.getChild(0)  instanceof Java8Parser.ExpressionContext){
            System.out.println("\t\t call variable: " + ctx.getChild(0).getText());
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("call variable"+"," + ctx.getChild(0).getText());
                } catch (IOException i) {
                    i.printStackTrace();
                }
            if (ctx.argumentList() != null) {
                for (int i = 0; i < ctx.argumentList().expression().size(); i++) {
                    System.out.println("\t\t argument: " +
                            ctx.argumentList().expression(i).getText() + " ,"+" ExpressionContext");
                    try (FileWriter writer = new FileWriter("test.txt", true);
                         BufferedWriter bufferedWriter = new BufferedWriter(writer);
                         PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                        printWriter.println("argument"+"," + ctx.argumentList().expression(i).getText());
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                }
            }
        }


    }
}
