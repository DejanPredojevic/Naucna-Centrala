import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { AdminApprovalComponent } from './admin-approval/admin-approval.component';
import { UserApproveComponent } from './user-approve/user-approve.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { Shared } from './services/Token';
import { NewMagizaineDataComponent } from './new-magizaine-data/new-magizaine-data.component';
import { NewEditorAndReviwerComponent } from './new-editor-and-reviwer/new-editor-and-reviwer.component';
import { AdminCheckComponent } from './admin-check/admin-check.component';
import { UrednikKorekcijaComponent } from './urednik-korekcija/urednik-korekcija.component';
import { AdminPublishComponent } from './admin-publish/admin-publish.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    HomeComponent,
    AdminApprovalComponent,
    UserApproveComponent,
    NavbarComponent,
    LoginComponent,
    NewMagizaineDataComponent,
    NewEditorAndReviwerComponent,
    AdminCheckComponent,
    UrednikKorekcijaComponent,
    AdminPublishComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ Shared ],
  bootstrap: [AppComponent]
})
export class AppModule { }
