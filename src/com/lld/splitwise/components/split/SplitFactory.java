package com.lld.splitwise.components.split;

import com.lld.splitwise.components.split.impl.EqualSplit;
import com.lld.splitwise.components.split.impl.ExactSplit;
import com.lld.splitwise.components.split.impl.PercentageSplit;
import com.lld.splitwise.constants.SplitType;

public class SplitFactory {

    public static Split createSplit(SplitType splitType){
        if(splitType.equals(SplitType.EQUAL)){
            return new EqualSplit();
        } else if(splitType.equals(SplitType.EXACT)){
            return new ExactSplit();
        } else if(splitType.equals(SplitType.PERCENTAGE)){
            return new PercentageSplit();
        }
        return null;
    }
}
