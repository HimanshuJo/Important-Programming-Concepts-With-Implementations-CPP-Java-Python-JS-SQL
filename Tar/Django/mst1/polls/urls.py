from django.urls import path
from . import views

app_name = 'polls'
urlpatterns = [
    path('', views.index2, name='index'),
    path('<int:ques_id>/', views.detail2, name='detail'),
    path('<int:ques_id/results/', views.results, name='results'),
    path('<int:ques_id/vote/', views.vote, name='vote'),
]
