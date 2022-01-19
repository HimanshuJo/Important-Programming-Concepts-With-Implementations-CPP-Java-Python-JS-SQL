from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from django.http import Http404
from django.template import loader
from django.shortcuts import get_object_or_404
from .models import Ques, Choice
from django.views import generic
from django.utils import timezone


class IndexView(generic.ListView):
    template_name = 'polls/index.html'
    context_object_name = 'lat_ques_list'

    def get_queryset(self):
        return Ques.objects.filter(pub_date__lte=timezone.now()).order_by('-pub_date')[:5]


class DetailView(generic.DetailView):
    model = Ques
    template_name = 'polls/detail.html'


class ResultsView(generic.DetailView):
    model = Ques
    template_name = 'polls/results.html'


def index(request):
    lat_ques_list = Ques.objects.order_by('-pub_date')[:5]
    template = loader.get_template('polls/index.html')
    context = {
        'lat_ques_list': lat_ques_list,
    }
    # output = '. '.join([q.ques_text for q in lat_ques_list])
    # return HttpResponse('Test here')
    return HttpResponse(template.render(context, request))


def index2(request):
    lat_ques_list = Ques.objects.order_by('-pub_date')[:5]
    context = {'lat_ques_list': lat_ques_list}
    return render(request, 'polls/index.html', context)


def detail(request, ques_id):
    try:
        ques = Ques.objects.get(pk=ques_id)
    except Ques.DoesNotExist:
        raise Http404('Ques does not exist')
    return render(request, 'polls/detail.html', {'ques': ques})
    # return HttpResponse("At question num %s." % ques_id)


def detail2(request, ques_id):
    ques = get_object_or_404(Ques, pk=ques_id)
    return render(request, 'polls/detail.html', {'ques': ques})


def detail3(request, ques_id):
    return HttpResponse("At question num %s." % ques_id)


def results(request, ques_id):
    ques = get_object_or_404(Ques, pk=ques_id)
    return render(request, 'polls/results.html', {'ques': ques})
    # response = "Currently at ques %s"
    # return HttpResponse(response % ques_id)


def vote(request, ques_id):
    ques = get_object_or_404(Ques, pk=ques_id)
    try:
        selected_choice = ques.choice_set.get(pk=request.POST['choice'])
    except (KeyError, Choice.DoesNotExist):
        return render(request, 'polls/detail.html', {'ques': ques, 'error_message': "No choice selected"})
    else:
        selected_choice.votes += 1
        selected_choice.save()
        return HttpResponseRedirect(reverse('polls:results', args=(ques.id,)))
    # return HttpResponse("Current voting at ques %s." % ques_id)
