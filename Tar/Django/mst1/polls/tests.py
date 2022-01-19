from django.test import TestCase
import datetime
from django.utils import timezone
from .models import Ques
from django.urls import reverse


def create_ques(ques_text, days):
    time = timezone.now() + datetime.timedelta(days=days)
    return Ques.objects.create(ques_text=ques_text, pub_date=time)


class QuesIndexViewTests(TestCase):
    def test_no_ques(self):
        response = self.client.get(reverse('polls:index'))
        self.assertEqual(response.status_code, 200)
        self.assertContains(response, "No polls")
        self.assertQuerysetEqual(response.context['lat_ques_list'], [])

    def test_past_ques(self):
        create_ques(ques_text="Past ques.", days=-30)
        response = self.client.get(reverse('polls:index'))
        self.assertQuerysetEqual(response.context['lat_ques_list'], ['<Ques: Past ques.>'])

    def test_future_ques(self):
        create_ques(ques_text="Future ques.", days=30)
        response = self.client.get(reverse('polls:index'))
        self.assertContains(response, "No polls")
        self.assertQuerysetEqual(response.context['lat_ques_list'], [])

    def test_future_ques_and_past_ques(self):
        create_ques(ques_text="Past ques.", days=-30)
        create_ques(ques_text="Future ques.", days=30)
        response = self.client.get(reverse('polls:index'))
        self.assertQuerysetEqual(response.context['lat_ques_list'], ['<Ques: Past ques.>'])

    ''' def test_two_past_ques(self):
        create_ques(ques_text="Past ques 1.", days=-30)
        create_ques(ques_text="Past ques 2.", days=-5)
        response = self.client.get(reverse('polls:index'))
        self.assertQuerysetEqual(response.context['lat_ques_list'], ['<Ques:Past ques 2.>'], ['<Ques:Past ques 1.>'])'''


class QuesModelTest(TestCase):
    def test_was_pub_recently_with_fut_ques(self):
        time = timezone.now() + datetime.timedelta(days=30)
        future_ques = Ques(pub_date=time)
        self.assertIs(future_ques.was_pub_recently(), False)

    def test_was_pub_recently_with_old_ques(self):
        time = timezone.now() - datetime.timedelta(days=1, seconds=1)
        old_ques = Ques(pub_date=time)
        self.assertIs(old_ques.was_pub_recently(), False)

    def test_was_pub_recently_with_recent_ques(self):
        time = timezone.now() - datetime.timedelta(hours=23, minutes=59, seconds=59)
        recent_ques = Ques(pub_date=time)
        self.assertIs(recent_ques.was_pub_recently(), True)
