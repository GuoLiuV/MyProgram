package com.littlefox;

import com.littlefox.xirr.IRRUtil;
import com.littlefox.xirr.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple IRR.
 */
public class IRRTest {

    @Test
    public void XIRR() {
        List list = Arrays.asList(
                new Transaction(-5000000  ,  "2020-03-01"),

                new Transaction(10000000  ,  "2020-03-03")

        );

        System.out.println("========> " +IRRUtil.xirr(list,365,0.3).toString());
        //Assert.assertEquals("0.3733625335190808",IRRUtil.xirr(list,365).toString());
        //Assert.assertEquals("0.3733625335188315",IRRUtil.xirr(list,365,0.1D).toString());
    }

    @Test
    public void IRR() {
        Double[] arrays= {-700000.0,120000.0,150000.0,180000.0,210000.0,260000.0};

        List<Transaction> list= Arrays.asList(arrays).stream().map(x ->{
            return new Transaction(x);
        }).collect(Collectors.toList());

        Assert.assertEquals("0.08663094803653153",IRRUtil.irr(list).toString());
        Assert.assertEquals("0.0866309480365316",IRRUtil.irr(list,0.3D).toString());
    }
}
