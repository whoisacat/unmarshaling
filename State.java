package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Класс для десериализации списка состояний светофоров из XML файла Комсигнала
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class State{

    @XmlElement(name = "ID")
    private String id;

    @XmlElement(name = "STATUS")
    private String status;

    @XmlElement(name = "CODE")
    private String code;

    @XmlElement(name = "MODE")
    private String mode;

    @XmlElement(name = "PHASE")
    private int phase;

    @Override
    public int hashCode(){
        return Integer.parseInt(id);
    }

    @Override
    public boolean equals(Object o){
        return this.id == ((State) o).id;
    }
}
