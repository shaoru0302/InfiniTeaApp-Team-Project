//Scenario 1: Navigate to Build-Your-Own Page
package com.example.buildyourownfeature;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class NaviTest{
    @Test
    public void testPathToBuildYourOwnPage(){
        NavigationController nav = NavigationController();
        nav,navigateTo("BuildYourOwn");
        assertEquals("BuildYourOwn", nav.getCurrentPage());
    }
}