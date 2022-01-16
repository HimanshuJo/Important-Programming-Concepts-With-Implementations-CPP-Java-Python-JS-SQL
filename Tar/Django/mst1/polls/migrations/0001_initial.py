# Generated by Django 4.0.1 on 2022-01-13 07:58

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Rep',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('f_name', models.CharField(max_length=76)),
            ],
        ),
        migrations.CreateModel(
            name='Artic',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('pub_d', models.DateField()),
                ('headl', models.CharField(max_length=200)),
                ('content', models.TextField()),
                ('rep', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='polls.rep')),
            ],
        ),
    ]
