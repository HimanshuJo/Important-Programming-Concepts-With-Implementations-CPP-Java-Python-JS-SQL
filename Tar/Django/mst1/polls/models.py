import datetime
from django.db import models
from django.utils import timezone


class Ques(models.Model):
    ques_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date pub')

    def was_pub_recently(self):
        # return self.pub_date >= timezone.now() - datetime.timedelta(days=1)
        now = timezone.now()
        return now - datetime.timedelta(days=1) <= self.pub_date <= now

    def __str__(self):
        return self.ques_text


class Choice(models.Model):
    ques = models.ForeignKey(Ques, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

    def __str__(self):
        return self.choice_text
