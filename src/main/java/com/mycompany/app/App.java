package com.mycompany.app;

import java.util.ArrayList;

import com.mycompany.app.conf.Condition;
import com.mycompany.app.conf.Config;
import com.mycompany.app.output.ConsoleOutput;
import com.mycompany.app.output.OutputDevice;
import com.mycompany.app.service.PrinterService;

public class App {
    private static PrinterService printerService = new PrinterService();

    public static void main(String[] args) {

        /*
        I've used here conditions from the assignment . If you want to change a conditions or count of numbers in array,
        just create a new condition object or the specific count of numbers. This could be sent as a requestBody over
        some HTTP request to call business logic and get the output. There are a lot of possible options how to handle
        triggering of the code and possible ways of output depends on requirements. In this case I have implemented
        program, you can use consoleOutput or fileOutput.
         */
        ArrayList<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition(2,"foo"));
        conditions.add(new Condition(4,"fuu"));
        OutputDevice consoleOutput = new ConsoleOutput();
        Config config = new Config(100,conditions);


        printerService.usePrinter(config, consoleOutput);


    }

}
