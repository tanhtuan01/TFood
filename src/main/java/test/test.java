package test;

import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tfood.model.CartDTO;
import com.tfood.service.CartService;


public class test {


	public static void main(String[] args) {

		Calendar instance = Calendar.getInstance();
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int year = instance.get(Calendar.YEAR);
        System.out.println((month+1));
        System.out.println(year);
		for(int i =0; i < 10 ;i++) {
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid);

		}
	}
	
}
