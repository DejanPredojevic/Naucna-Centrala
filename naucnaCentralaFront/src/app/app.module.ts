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
import { UserPageComponent } from './user-page/user-page.component';
import { NewArticleComponent } from './new-article/new-article.component';
import { ArticleInfoComponent } from './article-info/article-info.component';
import { TematikaComponent } from './tematika/tematika.component';
import { ArticleCheckComponent } from './article-check/article-check.component';
import { AdminPdfCheckComponent } from './admin-pdf-check/admin-pdf-check.component';
import { PopravkaPdfComponent } from './popravka-pdf/popravka-pdf.component';
import { PdfCorectionComponent } from './pdf-corection/pdf-corection.component';
import { UrednikChooseRecenzenteComponent } from './urednik-choose-recenzente/urednik-choose-recenzente.component';
import { ChooseRecenzenteComponent } from './choose-recenzente/choose-recenzente.component';
import { RecenzentPregledComponent } from './recenzent-pregled/recenzent-pregled.component';
import { RecenzentPregledaComponent } from './recenzent-pregleda/recenzent-pregleda.component';
import { UrednikPregledaRecenzijeComponent } from './urednik-pregleda-recenzije/urednik-pregleda-recenzije.component';
import { OdobravanjeArticlaComponent } from './odobravanje-articla/odobravanje-articla.component';

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
    AdminPublishComponent,
    UserPageComponent,
    NewArticleComponent,
    ArticleInfoComponent,
    TematikaComponent,
    ArticleCheckComponent,
    AdminPdfCheckComponent,
    PopravkaPdfComponent,
    PdfCorectionComponent,
    UrednikChooseRecenzenteComponent,
    ChooseRecenzenteComponent,
    RecenzentPregledComponent,
    RecenzentPregledaComponent,
    UrednikPregledaRecenzijeComponent,
    OdobravanjeArticlaComponent
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
