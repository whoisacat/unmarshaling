package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import java.io.IOException;

public class MyUnmarshallerException extends IOException{
    MyUnmarshallerException(){
        super("Unknown filetype");
    }
}
