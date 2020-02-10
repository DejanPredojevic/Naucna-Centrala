import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { AdminApprovalComponent } from './admin-approval/admin-approval.component';
import { UserApproveComponent } from './user-approve/user-approve.component';
import { LoginComponent } from './login/login.component';
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
    path: 'articleCheck/:procesID',
    component: ArticleCheckComponent
  },
  {
    path: 'pdfCorect/:procesID',
    component: PdfCorectionComponent
  },
  {
    path: 'pdfCheck/:procesID',
    component: AdminPdfCheckComponent
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
    path: 'newArticle',
    component: NewArticleComponent
  },
  {
    path: 'checkArticle',
    component: TematikaComponent
  },
  {
    path: 'pdfCorect',
    component: PopravkaPdfComponent
  },
  {
    path: 'articleInfo/:procesID',
    component: ArticleInfoComponent
  },
  {
    path: 'newEditorAndReviwer/:procesID',
    component: NewEditorAndReviwerComponent
  },
  {
    path: 'adminCheck/:procesID',
    component: AdminCheckComponent
  },
  {
    path: 'urednikCorect/:procesID',
    component: UrednikKorekcijaComponent
  },
  {
    path: 'adminPublish/:procesID',
    component: AdminPublishComponent
  },
  {
    path: 'userPage',
    component: UserPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
