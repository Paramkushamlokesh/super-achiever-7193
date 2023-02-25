package com.mgnregs.loginverification;

import java.util.Scanner;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dto.BDO;
import com.mgnregs.dto.GPM;

public interface Login {
	public BDO verifyBDOlogin(String user,String pass)throws MGNREGSException;
	public GPM verifyGPMlogin(String user,String pass)throws MGNREGSException;
}
