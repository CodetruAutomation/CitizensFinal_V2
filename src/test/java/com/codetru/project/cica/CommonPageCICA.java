package com.codetru.project.cica;

import com.codetru.project.cica.pages.customerModule.Customer_Module;
import com.codetru.project.cica.pages.dashboardModule.AgencyDashboard;
import com.codetru.project.cica.pages.dashboardModule.Dashboard;
import com.codetru.project.cica.pages.loginModule.LoginModule;
import com.codetru.project.cica.pages.policyPaymentsModule.PolicyPaymentModule;
import com.codetru.project.cica.pages.profileModule.Profile_Module;
import com.codetru.project.cica.pages.regressionApplicationModule.HomePage;
import com.codetru.project.cica.pages.regressionApplicationModule.LoginPage;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_10Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_1Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_1Page_Guarantee;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_2Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_3Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_4Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_5Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_6Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_6Page_HQ_Yes;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_7Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_7PageHIPAA;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_8Page;
import com.codetru.project.cica.pages.regressionApplicationModule.Step_9Page;
import com.codetru.project.cica.pages.reportsModule.AccountBalanceHistory;
import com.codetru.project.cica.pages.reportsModule.AccountBalanceReport;
import com.codetru.project.cica.pages.reportsModule.ActivityReports;
import com.codetru.project.cica.pages.reportsModule.ApplicationPaymentStatusReport;
import com.codetru.project.cica.pages.reportsModule.CheckReport;
import com.codetru.project.cica.pages.reportsModule.CheckReportHistory;
import com.codetru.project.cica.pages.reportsModule.PaymentRefusedReport;
import com.codetru.project.cica.pages.reportsModule.RenewalPremiumReports;
import com.codetru.project.cica.pages.reportsModule.StatusReport;
import com.codetru.project.cica.pages.sanityApplicationModule.HomePage_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.LoginPage_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_10PageACH;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_10Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_1Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_1Page_NV_Guarantee;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_2Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_3Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_4Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_5Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_6Page_HQ_Yes_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_6Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_7PageHIPAA_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_7PageHIPAA_NV2;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_7Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_8Page_NV;
import com.codetru.project.cica.pages.sanityApplicationModule.Step_9Page_NV;
import com.codetru.project.cica.utils.HomePage_Modules;

public class CommonPageCICA {

	private LoginPage loginCICA;
	private HomePage homePage;
	private Step_1Page step_1Page;
	private Step_2Page step_2Page;
	private Step_3Page step_3Page;
	private Step_4Page step_4Page;
	private Step_5Page step_5Page;
	private Step_6Page step_6Page;
	private Step_6Page_HQ_Yes step_6Page_HQ_Yes;
	private Step_7Page step_7Page;
	private Step_7PageHIPAA step_7PageHIPAA;
	private Step_8Page step_8Page;
	private Step_9Page step_9Page;
	private Step_10Page step_10Page;

	//No Validation Classes
	private LoginPage_NV loginPage_NV;
	private HomePage_NV homePage_NV_All;
	private Step_1Page_NV step_1Page_NV;
	private Step_2Page_NV step_2Page_NV;
	private Step_3Page_NV step_3Page_NV;
	private Step_4Page_NV step_4Page_NV;
	private Step_5Page_NV step_5Page_NV;
	private Step_6Page_NV step_6Page_NV;
	private Step_6Page_HQ_Yes_NV step_6Page_HQ_Yes_NV;
	private Step_7PageHIPAA_NV step_7PageHIPAA_NV;
	private Step_7PageHIPAA_NV2 step_7PageHIPAA_NV2;
	private Step_7Page_NV step_7Page_NV;
	private Step_8Page_NV step_8Page_NV;
	private Step_9Page_NV step_9Page_NV;
	private Step_10Page_NV step_10Page_NV;
	private Step_10PageACH step_10Page_ACH;

	//Payment, Report Modules
	public PolicyPaymentModule policypayment;
	private Customer_Module customer_module;
	private Profile_Module profile_module;
	private Dashboard dashboard;
	private ActivityReports activityReports;
	private RenewalPremiumReports renewalReports;
	private HomePage_Modules homePage_payments;
	private ApplicationPaymentStatusReport applicationPaymentStatusReport;
	private CheckReport checkReport;
	private CheckReportHistory checkReportHistory;
	private PaymentRefusedReport paymentRefusedReport;
	private AgencyDashboard agencyDashboard;
	private AccountBalanceReport accountBalanceReport;
	private AccountBalanceHistory accountBalanceHistory;
	private LoginModule loginModule;
	private StatusReport statusReport;

	//Guaranteed Issue
	private Step_1Page_Guarantee step_1Page_Guarantee;
	private Step_1Page_NV_Guarantee step_1Page_NV_Guarantee;

//************************************* Application Module Reference *****************************************
	public LoginPage getLoginPage() {
		if (loginCICA == null) {
			loginCICA = new LoginPage();
		}
		return loginCICA;
	}

	public HomePage getHomePage() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}

	public Step_1Page getStep_1Page() {
		if (step_1Page == null) {
			step_1Page = new Step_1Page();
		}
		return step_1Page;
	}

	public Step_2Page getStep_2Page() {
		if (step_2Page == null) {
			step_2Page = new Step_2Page();
		}
		return step_2Page;
	}

	public Step_3Page getStep_3Page() {
		if (step_3Page == null) {
			step_3Page = new Step_3Page();
		}
		return step_3Page;
	}

	public Step_4Page getStep_4Page() {
		if (step_4Page == null) {
			step_4Page = new Step_4Page();
		}
		return step_4Page;
	}

	public Step_5Page getStep_5Page() {
		if (step_5Page == null) {
			step_5Page = new Step_5Page();
		}
		return step_5Page;
	}

	public Step_6Page getStep_6Page() {
		if (step_6Page == null) {
			step_6Page = new Step_6Page();
		}
		return step_6Page;
	}

	public Step_6Page_HQ_Yes getStep_6Page_HQ_Yes() {
		if (step_6Page_HQ_Yes == null) {
			step_6Page_HQ_Yes = new Step_6Page_HQ_Yes();
		}
		return step_6Page_HQ_Yes;
	}
	
	public Step_7Page getStep_7Page() {
		if (step_7Page == null) {
			step_7Page = new Step_7Page();
		}
		return step_7Page;
	}

	public Step_7PageHIPAA getStep_7PageHIPAA() {
		if (step_7PageHIPAA == null) {
			step_7PageHIPAA = new Step_7PageHIPAA();
		}
		return step_7PageHIPAA;
	}

	public Step_8Page getStep_8Page() {
		if (step_8Page == null) {
			step_8Page = new Step_8Page();
		}
		return step_8Page;
	}

	public Step_9Page getStep_9Page() {
		if (step_9Page == null) {
			step_9Page = new Step_9Page();
		}
		return step_9Page;
	}

	public Step_10Page getStep_10Page() {
		if (step_10Page == null) {
			step_10Page = new Step_10Page();
		}
		return step_10Page;
	}

// ************************** No Validation Classes ******************************************************************************
	public LoginPage_NV getLoginPage_NV() {
		if (loginPage_NV == null) {
			loginPage_NV = new LoginPage_NV();
		}
		return loginPage_NV;
	}


	public HomePage_NV getHomePage_NV_All() {
		if (homePage_NV_All == null) {
			homePage_NV_All = new HomePage_NV();
		}
		return homePage_NV_All;
	}

	public Step_1Page_NV getStep_1Page_NV() {
		if (step_1Page_NV == null) {
			step_1Page_NV = new Step_1Page_NV();
		}
		return step_1Page_NV;
	}

	public Step_2Page_NV getStep_2Page_NV() {
		if (step_2Page_NV == null) {
			step_2Page_NV = new Step_2Page_NV();
		}
		return step_2Page_NV;
	}

	public Step_3Page_NV getStep_3Page_NV() {
		if (step_3Page_NV == null) {
			step_3Page_NV = new Step_3Page_NV();
		}
		return step_3Page_NV;
	}

	public Step_4Page_NV getStep_4Page_NV() {
		if (step_4Page_NV == null) {
			step_4Page_NV = new Step_4Page_NV();
		}
		return step_4Page_NV;
	}

	public Step_5Page_NV getStep_5Page_NV() {
		if (step_5Page_NV == null) {
			step_5Page_NV = new Step_5Page_NV();
		}
		return step_5Page_NV;
	}

	public Step_6Page_NV getStep_6Page_NV() {
		if (step_6Page_NV == null) {
			step_6Page_NV = new Step_6Page_NV();
		}
		return step_6Page_NV;
	}

	public Step_6Page_HQ_Yes_NV getStep_6Page_HQ_Yes_NV() {
		if (step_6Page_HQ_Yes_NV == null) {
			step_6Page_HQ_Yes_NV = new Step_6Page_HQ_Yes_NV();
		}
		return step_6Page_HQ_Yes_NV;
	}
	
	public Step_7PageHIPAA_NV getStep_7PageHIPAA_NV() {
		if (step_7PageHIPAA_NV == null) {
			step_7PageHIPAA_NV = new Step_7PageHIPAA_NV();
		}
		return step_7PageHIPAA_NV;
	}

	public Step_7PageHIPAA_NV2 getStep_7PageHIPAA_NV2() {
		if (step_7PageHIPAA_NV2 == null) {
			step_7PageHIPAA_NV2 = new Step_7PageHIPAA_NV2();
		}
		return step_7PageHIPAA_NV2;
	}

	public Step_7Page_NV getStep_7Page_NV() {
		if (step_7Page_NV == null) {
			step_7Page_NV = new Step_7Page_NV();
		}
		return step_7Page_NV;
	}

	public Step_8Page_NV getStep_8Page_NV() {
		if (step_8Page_NV == null) {
			step_8Page_NV = new Step_8Page_NV();
		}
		return step_8Page_NV;
	}

	public Step_9Page_NV getStep_9Page_NV() {
		if (step_9Page_NV == null) {
			step_9Page_NV = new Step_9Page_NV();
		}
		return step_9Page_NV;
	}

	public Step_10Page_NV getStep_10Page_NV() {
		if (step_10Page_NV == null) {
			step_10Page_NV = new Step_10Page_NV();
		}
		return step_10Page_NV;
	}

	public Step_10PageACH getStep_10PageACH() {
		if (step_10Page_ACH == null) {
			step_10Page_ACH = new Step_10PageACH();
		}
		return step_10Page_ACH;
	}

//**************************** Payment, Reports and Other Modules ******************************************************************************
	public PolicyPaymentModule getPolicyPaymentModule() {
		if (policypayment == null) {
			policypayment = new PolicyPaymentModule();
		}
		return policypayment;
	}
	
	public Dashboard getDashboard() {
		if (dashboard == null) {
			dashboard = new Dashboard();
		}
		return dashboard;
	}

	public RenewalPremiumReports getRenewalPremiumReports() {
		if (renewalReports == null) {
			renewalReports = new RenewalPremiumReports();
		}
		return renewalReports;
	}


	public ActivityReports getActivityReports() {
		if (activityReports == null) {
			activityReports = new ActivityReports();
		}
		return activityReports;
	}

	public Profile_Module getProfile_Module() {
		if (profile_module == null) {
			profile_module = new Profile_Module();
		}
		return profile_module;
	}
	public Customer_Module getCustumer_Module() {
		if (customer_module == null) {
			customer_module = new Customer_Module();
		}
		return customer_module;
	}

	public HomePage_Modules getHomePage_Payments() {
		if (homePage_payments == null) {
			homePage_payments = new HomePage_Modules();
		}
		return homePage_payments;
	}
	
	public ApplicationPaymentStatusReport getApplicationPaymentStatusReport() {
		if (applicationPaymentStatusReport == null) {
			applicationPaymentStatusReport = new ApplicationPaymentStatusReport();
		}
		return applicationPaymentStatusReport;
	}

	public CheckReport getcheckReport() {
		if (checkReport == null) {
			checkReport = new CheckReport();
		}
		return checkReport;
	}
	
	public CheckReportHistory getCheckReportHistory() {
		if (checkReportHistory == null) {
			checkReportHistory = new CheckReportHistory();
		}
		return checkReportHistory;
	}
	
	public PaymentRefusedReport getPaymentRefusedReport() {
		if (paymentRefusedReport == null) {
			paymentRefusedReport = new PaymentRefusedReport();
		}
		return paymentRefusedReport;
	}
	
	public AgencyDashboard getAgencyDashboard() {
		if (agencyDashboard == null) {
			agencyDashboard = new AgencyDashboard();
		}
		return agencyDashboard;
	}
	
	public AccountBalanceReport getAccountBalanceReport() {
		if (accountBalanceReport == null) {
			accountBalanceReport = new AccountBalanceReport();
		}
		return accountBalanceReport;
	}
	
	public AccountBalanceHistory getAccountBalanceHistory() {
		if (accountBalanceHistory == null) {
			accountBalanceHistory = new AccountBalanceHistory();
		}
		return accountBalanceHistory;
	}
	
	public StatusReport getStatusReport() {
		if (statusReport == null) {
			statusReport = new StatusReport();
		}
		return statusReport;
	}
	
	public LoginModule getLoginModule() {
		if (loginModule == null) {
			loginModule = new LoginModule();
		}
		return loginModule;
	}
	
	
//	************************* For Guaranteed Issue classes ******************************************************************************
	public Step_1Page_Guarantee getStep_1Page_Guarantee() {
		if (step_1Page_Guarantee == null) {
			step_1Page_Guarantee = new Step_1Page_Guarantee();
		}
		return step_1Page_Guarantee;
	}
	
	public Step_1Page_NV_Guarantee getStep_1Page_NV_Guarantee() {
		if (step_1Page_NV_Guarantee == null) {
			step_1Page_NV_Guarantee = new Step_1Page_NV_Guarantee();
		}
		return step_1Page_NV_Guarantee;
	}


}
