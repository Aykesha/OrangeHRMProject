package com.orangeHRM.endpoints;

import lombok.Getter;

public enum SideBarMenuEndpoints {



    ADMIN("/admin/viewSystemUsers"),
    PIM("/pim/viewEmployeeList"),
    LEAVE("/leave/viewLeaveList"),
    TIME("/time/viewEmployeeTimesheet"),
    RECRUITMENT("/recruitment/viewCandidates"),
    MYINFO("/pim/viewPersonalDetails/empNumber/7"),
    PERFORMANCE("/performance/searchEvaluatePerformanceReview"),
    DASHBOARD("/dashboard/index"),
    DIRECTORY("/directory/viewDirectory"),
    MAINTENANCE("/"),
    CLAIM("/claim/viewAssignClaim"),
    BUZZ("/buzz/viewBuzz");

    @Getter
    String menu;

    SideBarMenuEndpoints(String menu){
        this.menu=menu;
    }

    public String getSideBarMenuEnum() {
        return menu;
    }
}
