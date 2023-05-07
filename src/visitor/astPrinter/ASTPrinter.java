package visitor.astPrinter;
package com.tutorialspoint;

import java.util.GregorianCalendar;

import ast.node.declaration.FuncDeclaration;
import ast.node.declaration.MainDeclaration;
import ast.node.Program;
import ast.node.declaration.ArgDeclaration;
import ast.node.expression.*;
import ast.node.expression.values.*;
import ast.node.statement.*;
import visitor.Visitor;

public class ASTPrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message){
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
        for (FuncDeclaration funcDeclaration : program.getFuncs())
            funcDeclaration.accept(this);
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        messagePrinter(mainDeclaration.getLine(), mainDeclaration.toString());
        for (Statement statement: mainDeclaration.getMainStatements())
            statement.accept(this);
        return null;
    }

    @Override
    public Void visit(ArgDeclaration argDeclaration) {
        messagePrinter(argDeclaration.getLine(), argDeclaration.toString());
        if (argDeclaration.getIdentifier() != null)
            argDeclaration.getIdentifier().accept(this);
        return null;
    }

    @Override
    public Void visit(FuncDeclaration funcDeclaration) {
        messagePrinter(funcDeclaration.getLine(), funcDeclaration.toString());
        for (ArgDeclaration argDeclaration: funcDeclaration.getStatements()) {
            argDeclaration.accept(this);
        }

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        if(unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);

        if(unaryExpression.getUnaryOperator() != null)
            unaryExpression.getUnaryOperator().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        
        if(binaryExpression.getLeft() != null)
            binaryExpression.getLeft().accept(this);
        
        if(binaryExpression.getRight() != null)
            binaryExpression.getRight().accept(this);

        if(binaryExpression.getBinaryOperator() != null)
            binaryExpression.getBinaryOperator().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.toString());
        if (identifier.name != null)
            identifier.name.accept(this);
        // ToDo              

        //not sure
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess) {
        messagePrinter(arrayAccess.getLine(), arrayAccess.toString());
        arrayAccess.getIndex.accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(FunctionCall functionCall) {
        messagePrinter(functionCall.getLine(), functionCall.toString());

        for(FunctionCall functionCall: functionCall.getArgs())
            functionCall.getArgs.accept(this);

        // ToDo

        //done
        return null;
    }


    @Override
    public Void visit(QueryExpression queryExpression) {
        messagePrinter(queryExpression.getLine(), queryExpression.toString());
        
        if(queryExpression.getPredicateName() != null)
            queryExpression.getPredicateName().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(IntValue value) {
        messagePrinter(value.getLine(), value.toString());
       
        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(FloatValue value) {
        messagePrinter(value.getLine(), value.toString());

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(BooleanValue value) {
        messagePrinter(value.getLine(), value.toString());

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(ArrayDecStmt arrayDecStmt) {
        messagePrinter(arrayDecStmt.getLine(), arrayDecStmt.toString());

        if (arrayDecStmt.getIdentifier() != null)
            arrayDecStmt.getIdentifier().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(ForloopStmt forloopStmt) {
        messagePrinter(forloopStmt.getLine(), forloopStmt.toString());
        for (Statement statement: mainDeclaration.getStatements())
                statement.accept(this);
    
            // ToDo

            //done
        return null;
    }

    @Override
    public Void visit(ImplicationStmt implicationStmt) {
        messagePrinter(implicationStmt.getLine(), implicationStmt.toString());
        for (Statement statement: mainDeclaration.getStatements())
            statement.accept(this);
        
        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(PredicateStmt predicateStmt) {
        messagePrinter(predicateStmt.getLine(), predicateStmt.toString());
        if (predicateStmt.getIdentifier() != null)
            predicateStmt.getIdentifier().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        //if(returnStmt.getExpression() != null)
        returnStmt.getExpression().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        messagePrinter(varDecStmt.getLine(), varDecStmt.toString());
        //if (varDecStmt.getIdentifier() != null)
        varDecStmt.getIdentifier().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(PrintStmt printStmt) {
        messagePrinter(printStmt.getLine(), printStmt.toString());

        // if(printStmt.getArg() != null)
        printStmt.getArg().accept(this);

        // ToDo

        //done
        return null;
    }

    @Override
    public Void visit(AssignStmt assignStmt) {
        messagePrinter(assignStmt.getLine(), assignStmt.toString());

        //if(assignStmt.getLValue() != null)
        assignStmt.getLValue().accept(this);

        //if(assignStmt.getRValue() != null)
        assignStmt.getRValue().accept(this);

        // ToDo

        //done
        return null;
    }

}

