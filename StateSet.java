package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;

/**
 * Класс для десериализации списка состояний светофоров из XML файла Комсигнала
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "OBJECTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateSet implements ISet<State> {

    @XmlElement(name = "OBJ")
    private HashSet<State> mStateSet;


    public HashSet<State> getSet() {
        return mStateSet;
    }

    public void setSet(HashSet<State> stateSet) {
        mStateSet = stateSet;
    }

    public void add(State state) {
        if (this.mStateSet == null) {
            this.mStateSet = new HashSet<>();
        }
        this.mStateSet.add(state);
    }

    public State getItem(int id) {
        for (State state : mStateSet) {
            log.info("{}  {}", id, state.getId());
            if (Integer.parseInt(state.getId()) == id) {
                return state;
            }
        }
        return null;
    }
}
