import Java8.Java8BaseListener;
import Java8.Java8Parser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class methodListener2 extends Java8BaseListener {
    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        TerminalNode node = ctx.Identifier();
        String methodOfName = node.getText();

        System.out.println("Enter method name: " + methodOfName);
    }
}
