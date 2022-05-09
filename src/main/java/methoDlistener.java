import Java8.Java8BaseListener;
import Java8.Java8Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class methoDlistener extends Java8BaseListener {
    private List<String> errors = new ArrayList<>();

//    @Override
//    public void enterEveryRule(ParserRuleContext ctx){
////        System.out.println("rule name: " + ctx.getRuleContexts().getText());
//        System.out.println("rule entered : " + ctx.getText());
//    }

    @Override
    public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        System.out.println("enter class declaration :" + ctx.getText());
    }

    @Override
    public void enterNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        TerminalNode node = ctx.Identifier();

        System.out.println("Class Declaration: "+node.getText());
    }

    //    @Override
//    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
//        TerminalNode node = ctx.Identifier();
//        String methodName = node.getText();
//
//        if (Character.isUpperCase(methodName.charAt(0))) {
//            String error = String.format("Method %s is uppercased!", methodName);
//            errors.add(error);
//        }
//    }
}
