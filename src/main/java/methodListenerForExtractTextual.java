import Java8.Java8BaseListener;
import Java8.Java8Parser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        if (classCalled == null){
            classCalled = new HashMap<>();
        }
        classCalled.put(className, newClass);
        try (FileWriter writer = new FileWriter("test.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);){
             printWriter.println("Class!!"+className);
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Enter class: "+className);

    }

    @Override
    public void exitClassDeclaration(Java8Parser.ClassDeclarationContext ctx){
        System.out.println("Exit class: "+className);
    }

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        TerminalNode node = ctx.Identifier();
        methodName = node.getText();
        List<String> newMethod = new ArrayList<>();
        if(methodCalled == null){
            methodCalled = new HashMap<>();
        }
        methodCalled.put(methodName, newMethod);
        try (FileWriter writer = new FileWriter("test.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);){
            printWriter.println("Method!!"+methodName);
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Enter Method: "+ methodName);
    }

    @Override
    public void exitMethodBody(Java8Parser.MethodBodyContext ctx) {
//        try (FileWriter writer = new FileWriter("test.txt", true);
//             BufferedWriter bufferedWriter = new BufferedWriter(writer);
//             PrintWriter printWriter = new PrintWriter(bufferedWriter);){
//            printWriter.println(  methodName);
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
        System.out.println("Exit Method: "+ methodName);


    }

    @Override
    public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
//        String callMethod = null;
//        if (node != null){
//        callMethod = ctx.Identifier().getText();
//        }
//        System.out.println(callMethod);
//            try (FileWriter writer = new FileWriter("test.txt", true);
//                 BufferedWriter bufferedWriter = new BufferedWriter(writer);
//                 PrintWriter printWriter = new PrintWriter(bufferedWriter);){
//                printWriter.println("MethodName!!"+callMethod);
//            } catch (IOException i) {
//                i.printStackTrace();
//            }
        if (ctx.getChild(0)  instanceof Java8Parser.MethodNameContext){
            System.out.println(  ctx.getChild(0).getText());
            try (FileWriter writer = new FileWriter("test.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                printWriter.println("MethodName!!"+ctx.getChild(0).getText());
            } catch (IOException i) {
                i.printStackTrace();
            }
            argumentList(ctx);

        }
        if (ctx.getChild(0) instanceof Java8Parser.TypeNameContext){
            System.out.println(  ctx.getChild(0).getText());
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("TypeName!!"+ctx.getChild(0).getText());
                } catch (IOException i) {
                    i.printStackTrace();
                }
            argumentList(ctx);
        }
        if (ctx.getChild(0)  instanceof Java8Parser.ExpressionContext){
            System.out.println(  ctx.getChild(0).getText());
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("ExpressionName!!"+ctx.getChild(0).getText());
                } catch (IOException i) {
                    i.printStackTrace();
                }
            argumentList(ctx);
        }
        if (ctx.getChild(0) instanceof Java8Parser.PrimaryContext){
            System.out.println(  ctx.getChild(0).getText());
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("PrimaryName!!"+ctx.getChild(0).getText());
                } catch (IOException i) {
                    i.printStackTrace();
                }
            argumentList(ctx);
        }
        if (ctx.getChild(0) == null){
            argumentList(ctx);
        }

    }

    private void argumentList(Java8Parser.MethodInvocationContext ctx) {
        if (ctx.argumentList() != null) {
            for (int i = 0; i < ctx.argumentList().expression().size(); i++) {
                System.out.println(
                        ctx.argumentList().expression(i).getText()  );
                try (FileWriter writer = new FileWriter("test.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter);){
                    printWriter.println("argumentName!!"+ctx.argumentList().expression(i).getText());
                } catch (IOException a) {
                    a.printStackTrace();
                }
            }
        }
    }
}
