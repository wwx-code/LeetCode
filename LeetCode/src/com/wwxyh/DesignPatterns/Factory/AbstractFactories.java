package com.wwxyh.DesignPatterns.Factory;

/**
 * @Description: 抽象工厂模式
 * @Author: wwx
 * @Date: 2021/7/9 0:44
 */
public class AbstractFactories {
    public static void main(String[] args) {
        IDatabaseUtils databaseUtils = new MysqlDatabaseUtils();
//        IDatabaseUtils databaseUtils = new OracleDatabaseUtils();
        databaseUtils.getConnection().connect();
        databaseUtils.getCommand().command();
    }
}

//  变化： mysql，oracle...
//  不变： connection，command

interface IConnection{
    void connect();
}
interface ICommand{
    void command();
}
//抽象工厂：提供了产品的生成方法。
interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connected");
    }
}
class OracleConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("Oracle connected");
    }
}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}
class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("Oracle command");
    }
}

//具体工厂：实现了产品的生成方法。
class MysqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}
class OracleDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}