import Java8.Java8BaseListener;
import Java8.Java8Parser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class methodListener3 extends Java8BaseListener {

    String methodName = "";
    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        TerminalNode node = ctx.Identifier();
        methodName = node.getText();
        System.out.println("Enter method name: " + methodName);
    }

    @Override
    public void exitMethodBody(Java8Parser.MethodBodyContext ctx) {

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
        TerminalNode node = ctx.Identifier();
        String callMethod = node.getText();
        System.out.println("\t call method: " + callMethod);
    }
}
