from django.urls import path
from . import views
from django.conf import settings

app_name = 'polls'
urlpatterns = [
    # path('', views.index2, name='index'),
    # path('<int:ques_id>/', views.detail2, name='detail'),
    # path('<int:ques_id>/results/', views.results, name='results'),
    # path('<int:ques_id>/vote/', views.vote, name='vote'),

    path('', views.IndexView.as_view(), name='index'),
    path('<int:pk>/', views.DetailView.as_view(), name='detail'),
    path('<int:pk>/results/', views.ResultsView.as_view(), name='results'),
    path('<int:ques_id>/vote/', views.vote, name='vote'),
]
