/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.methority.equbox2;

/**
 *
 * @author manfred
 */
public class Equation {

    private boolean m_first;
    
    public Equation() {
        m_first = true;
    }

    public String Add(double v, String suff, boolean first) {
        String ret = new String();

        System.out.println("v=" + ret);

        if (v == 0)
            return "";
        
        if (v > 0.) {
            if (!m_first)
                ret += "+";
        } else {
            ret += "-";
        }
        
        m_first = false;
        System.out.println(ret);
 
        if (v < 0.)
            v = -v;
        
        if (v == 1. && !suff.equals("") ) {
            ret += suff;
            System.out.println(ret);
            return ret;
        }
        
        //if (v - (int)v == v) {
            ret += (int)v;
        //} else {
          //  ret += v;
        //}        
        
    
        System.out.println(ret);

    
        ret += suff;

        System.out.println(ret);
        
        return ret;
    }

    double FixConst(double a, double b) {
        return a*b;
    }
    
    double Fix(double a, double b) {
        if (a == 0)
        a = 1.;
        return a*b;
    }

    public double la = 0.;
    public double lb = 0.;
    public double lc = 0.;
    public double ld = 0.;
    
    public double ra = 0.;
    public double rb = 0.;
    public double rc = 0.;
    public double rd = 0.;

    
    
    public String Do(String e, String cmmd) {
        if (e.equals(""))
            return "";
        
        int i;
        
        la = 0.;
        lb = 0.;
        lc = 0.;
        ld = 0.;
    
        ra = 0.;
        rb = 0.;
        rc = 0.;
        rd = 0.;
   
    double sign = 1.;
    double num = 0.;
    boolean right = false;
    for (i=0; i<(int)e.length(); i++) {
      if (e.charAt(i) == ' ')
	continue;

      if (e.charAt(i) == '-') {
	sign = -1.;
	continue;
      }

      if (e.charAt(i) == '+') {
	sign = 1.;
	continue;
      }
      if (e.charAt(i) == '=') {
	right = true;
	if (num > 0)
	  ld = FixConst(num, sign);
	num = 0.;
	sign = 1.;
	continue;
      }
    
      if (e.charAt(i) == 'x') {
	if (right) 
	  ra = Fix(num, sign);
	else
	  la = Fix(num, sign);
	num = 0.;
	continue;
      }
      if (e.charAt(i) == 'y') {
	if (right) 
	  rb = Fix(num, sign);
	else
	  lb = Fix(num, sign);
	num = 0.;
	continue;
      }
      if (e.charAt(i) == 'z') {
	if (right) 
	  rc = Fix(num, sign);
	else
	  lc = Fix(num, sign);
	num = 0.;
	continue;
      }
      
      double d = e.charAt(i) - '0';
     
      num = 10*num + d;
      //cout << d << " " << num << " " << e[i] << endl;
    }
    rd = FixConst(num, sign);
  

  
    //cout << "RAW: " << e << endl;
    //cout << la << "x " << lb << "y " << lc << "z " << ld << "=" << ra << "x " << rb << "y " << rc << "z " << rd << endl;
    if (cmmd.equals("") || cmmd.equals("add") || cmmd.equals("sub"))
        return "";
  

    int what = 0;
    int where = 0;
    num = 0.;
    int signsub = 1;
    for (i=0; i<(int)cmmd.length(); i++) {
      if (cmmd.charAt(i) == ' ')
	continue;
      if (cmmd.charAt(i) == '+') {
	what = 1;
	continue;
      }
      if (cmmd.charAt(i) == '-') {
        if (what == 0) {  
            what = 2;
        }
        signsub = -1;
	continue;
      }
      if (cmmd.charAt(i) == '*') {
	what = 3;
	continue;
      }
      if (cmmd.charAt(i) == '/') {
	what = 4;
	continue;
      }
      if (cmmd.charAt(i) == '=') {
	what = 5;
	continue;
      }

      if (cmmd.charAt(i) == 'x') {
	where = 1;
	continue;
      }
      if (cmmd.charAt(i) == 'y') {
	where = 2;
	continue;
      }
      if (cmmd.charAt(i) == 'z') {
	where = 3;
	continue;
      }
    
      if (cmmd.charAt(i) < '0' || cmmd.charAt(i) > '9')
          return "ERR";
      
      double d = cmmd.charAt(i) - '0';     
      num = 10*num + d;
      //cout << "CMMD " << d << " " << num << " " << cmmd[i] << endl;
      //cout << "what: " << what << " where: " << where << endl;
     
    }
    if (what == 1) {
      if (where == 1) {
        if (num == 0)
            num = 1;
	la += num;
	ra += num;
      }
      if (where == 2) {
        if (num == 0)
            num = 1;
	lb += num;
	rb += num;
      }
      if (where == 3) {
        if (num == 0)
            num = 1;
	lc += num;
	rc += num;
      }
      if (where == 0) {
	ld += num;
	rd += num;
      }
    }


   if (what == 2) {
      if (where == 1) {
       if (num == 0)
            num = 1;
	la -= num;
	ra -= num;
      }
      if (where == 2) {
       if (num == 0)
            num = 1;
	lb -= num;
	rb -= num;
      }
      if (where == 3) {
       if (num == 0)
            num = 1;
	lc -= num;
	rc -= num;
      }
      if (where == 0) {
	ld -= num;
	rd -= num;
	//cout << "Subtract " << num << " from " << ld << " " << rd << endl;
      }
   }
   
   if (what == 3) {
     
     la *= num*signsub;
     lb *= num*signsub;
     lc *= num*signsub;
     ld *= num*signsub;
     ra *= num*signsub;
     rb *= num*signsub;
     rc *= num*signsub;
     rd *= num*signsub;
   }

        if (what == 4) {
            la /= num*signsub;
            lb /= num*signsub;
            lc /= num*signsub;
            ld /= num*signsub;
            ra /= num*signsub;
            rb /= num*signsub;
            rc /= num*signsub;
            rd /= num*signsub;
        }

        if (what == 5) {
            if (where == 1) {
                ld += la*num*signsub;
                la = 0;
                rd += ra*num*signsub;
                ra = 0;
            }
            if (where == 2) {
                ld += lb*num*signsub;
                lb = 0;
                rd += rb*num*signsub;
                rb = 0;
            }
            if (where == 3) {
                ld += lc*num*signsub;
                lc = 0;
                rd += rc*num*signsub;
                rc = 0;
            }
                
        
        }
        
        System.out.println("RESULT: " + la + "x" + lb + "y" + lc + "z" + ld + "=" + ra + "x" + rb + "y" + rc + "z" + rd);
        //return la + "x" + lb + "y" + lc + "z" + ld + "=" + ra + "x" + rb + "y" + rc + "z" + rd;
        
        m_first = true;
        String ret = Add(la, "x", false);
        ret += Add(lb, "y", false);
        ret += Add(lc, "z", false);
        ret += Add(ld, "",false);

        if (m_first == true)
            ret += "0";
        
        ret += "=";
        
        m_first = true;
        ret += Add(ra, "x", false);
        ret += Add(rb, "y", false);
        ret += Add(rc, "z", false);
        ret += Add(rd, "", false);
    
        if (m_first == true)
            ret += "0";
        
        return ret;
    } 
    
    
    public String AddSub(Equation e, int pm) {

        la += pm*e.la;
        lb += pm*e.lb;
        lc += pm*e.lc;
        ld += pm*e.ld;

        ra += pm*e.ra;
        rb += pm*e.rb;
        rc += pm*e.rc;
        rd += pm*e.rd;


        
        m_first = true;
        String ret = Add(la, "x", false);
        ret += Add(lb, "y", false);
        ret += Add(lc, "z", false);
        ret += Add(ld, "",false);

        if (m_first == true)
            ret += "0";
        
        ret += "=";
        
        m_first = true;
        ret += Add(ra, "x", false);
        ret += Add(rb, "y", false);
        ret += Add(rc, "z", false);
        ret += Add(rd, "", false);
 
        if (m_first == true)
            ret += "0";
    
        return ret;
    }
}

