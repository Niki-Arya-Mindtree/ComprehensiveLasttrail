package com.doctor.main.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.doctor.main.docinterface.DocAccSalary;
import com.doctor.main.model.Model;

public class DescSalary implements DocAccSalary , Comparator<Model> {
	

	@Override
	public List<Model> docSortSalary(List<Model> lmd) {
		Collections.sort(lmd); //sorting by salary decending order
		sameSalary(lmd);
		return lmd;
	}
	
	/*Sorting by same salary with datas with there name in ascending order*/
	@Override
	public List<Model> sameSalary(List<Model> lnmd) {

		List<Model> firstList =  new ArrayList<Model>();
		List<Model> finalList =  new ArrayList<Model>();
		for(int i=0;i<lnmd.size()-1;i++)
		{
			if(lnmd.get(i).getSalary()==lnmd.get(i+1).getSalary())
			{
				firstList.add(lnmd.get(i));
			}
			else 
			{
				
				firstList.add(lnmd.get(i));
				Collections.sort(firstList,new DescSalary());
				for(int j=0;j<firstList.size();j++)
				{	
					finalList.add(firstList.get(j));
					firstList.remove(j);
				}
			}
		}		
		return finalList;
	}
	
	
	
	@Override
	public int compare(Model o1, Model o2) {
		if(o1.getName().equals(o2.getName()))
			return 0;
		else if(o1.getName().compareTo(o2.getName())<0)
			return 1;
		else
			return -1;
	}

}
