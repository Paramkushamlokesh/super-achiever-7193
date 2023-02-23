package com.mgnregs.loginverification;

import java.util.Scanner;

import com.mgnregs.dto.BDO;
import com.mgnregs.dto.GPM;

public interface Login {
	public BDO verifyBDOlogin(Scanner sc);
	public GPM verifyGPMlogin(Scanner sc);
}
