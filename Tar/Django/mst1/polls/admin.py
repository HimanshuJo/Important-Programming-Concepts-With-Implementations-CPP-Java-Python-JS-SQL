from django.contrib import admin

from .models import Ques, Choice

'''class ChoiceInline(admin.StackedInline):
    model = Choice
    extra = 3'''


class ChoiceInline(admin.TabularInline):
    model = Choice
    extra = 3


class QuesAdmin(admin.ModelAdmin):
    # fields = ['pub_date', 'ques_text']
    '''
    fieldsets = [(None, {'fields': ['ques_text']}),
                 ('Date information', {'fields': ['pub_date']})
                 ]
                 '''
    list_display = ('ques_text', 'pub_date', 'was_pub_recently')
    inlines = [ChoiceInline]


admin.site.register(Ques, QuesAdmin)
# admin.set.register(Choice)
