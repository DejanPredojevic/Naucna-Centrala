import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { AdminApprovalComponent } from './admin-approval/admin-approval.component';
import { UserApproveComponent } from './user-approve/user-approve.component';
import { LoginComponent } from './login/login.component';
import { NewMagizaineDataComponent } from './new-magizaine-data/new-magizaine-data.component';
import { NewEditorAndReviwerComponent } from './new-editor-and-reviwer/new-editor-and-reviwer.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'register',
    component: RegistrationComponent
  },
  {
    path: 'approval',
    component: AdminApprovalComponent
  },
  {
    path: 'userApprove/:procesID',
    component: UserApproveComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'newMagazine',
    component: NewMagizaineDataComponent
  },
  {
    path: 'newEditorAndReviwer/:procesID',
    component: NewEditorAndReviwerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
