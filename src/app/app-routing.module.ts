import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDetailsComponent } from './component/user-details/user-details.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Default route redirects to login
  { path: 'login', component: LoginComponent }, // Route to the LoginComponent
  { path: ':id/dashboard', component: DashboardComponent }, // Route to the DashboardComponent
  { path: 'create-user',component: CreateAccountComponent  },
  { path: 'admin-login',component: AdminLoginComponent  },
  { path: 'admin-dashboard',component: AdminDashboardComponent  },
  {path: ':id/user-details', component: UserDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
