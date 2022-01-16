from django.shortcuts import render
from django.http import HttpResponse
from django.http import Http404
from django.template import loader
from django.shortcuts import get_object_or_404
from .models import Ques


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
    response = "Currently at ques %s"
    return HttpResponse(response % ques_id)


def vote(request, ques_id):
    return HttpResponse("Current voting at ques %s." % ques_id)
