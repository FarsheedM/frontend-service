#!/usr/bin/bash

helm upgrade \
	--install \
	--cleanup-on-fail \
	--force \
	--wait \
	--set-string image.repository="frontend-demo" \
	--set-string bachend_demo_url="http://bachend-demo.default.svc.cluster.local:8080/greeting" \
frontend-demo ./helm/frontend-demo
