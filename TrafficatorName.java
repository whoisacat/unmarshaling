package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс для десериализации списка объектов светофоров из XML файла Комсигнала
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "OBJ")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrafficatorName{

    @XmlElement(name = "ID")
    private String id;

    @XmlElement(name = "NAME")
    private String name;

    @XmlElement(name = "LONGTITUDE")
    private String longitude;

    @XmlElement(name = "LATITUDE")
    private String latitude;

    private State state;

    @Override
    public int hashCode(){
        return Integer.parseInt(id);
    }

    @Override
    public boolean equals(Object o){
        return (Integer.parseInt(this.id) == Integer.parseInt(((TrafficatorName)o).id) & (this.name.equals(
                ((TrafficatorName)o).name)));
    }
}
