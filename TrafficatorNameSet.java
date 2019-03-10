package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;

/**
 * Класс для десериализации списка объектов светофоров из XML файла Комсигнала
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "OBJECTS")
public class TrafficatorNameSet implements ISet<TrafficatorName>{

    private HashSet<TrafficatorName> mTrafficatorNameSet;

    public HashSet<TrafficatorName> getSet(){
        return mTrafficatorNameSet;
    }

    @XmlElement(name = "OBJ")
    public void setSet(HashSet<TrafficatorName> trafficatorNameSet){
        this.mTrafficatorNameSet = trafficatorNameSet;
    }

    public void add(TrafficatorName trafficatorName){
        if(this.mTrafficatorNameSet == null){
            this.mTrafficatorNameSet = new HashSet<>();
        }
        this.mTrafficatorNameSet.add(trafficatorName);
    }

    @Override public TrafficatorName getItem(int id){
        for(TrafficatorName trafficatorName : mTrafficatorNameSet){
            if(Integer.parseInt(trafficatorName.getId()) == id){
                return trafficatorName;
            }
        }
        return null;
    }
}
